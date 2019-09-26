package lift.wizard.community.controller;

import lift.wizard.community.dao.User;
import lift.wizard.community.dto.PaginationDTO;
import lift.wizard.community.mapper.QuestionMapper;
import lift.wizard.community.mapper.UserMapper;
import lift.wizard.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action")String action,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "10") Integer size,
                          Model model){

        User user = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        if (user == null){
            return "redirect:/";
        }

        if ("pDatas".equals(action)){
            model.addAttribute("section","pDatas");
            model.addAttribute("sectionName","个人资料");
        }else if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的问题");
        }else if ("repies".equals(action)){
            model.addAttribute("section","repies");
            model.addAttribute("sectionName","消息管理");
        }else if ("follows".equals(action)){
            model.addAttribute("section","follows");
            model.addAttribute("sectionName","关注列表");
        }

        PaginationDTO pagination = questionService.listByUserId(user.getId(), page, size);

        model.addAttribute("pagination", pagination);

        return "profile";
    }

}
