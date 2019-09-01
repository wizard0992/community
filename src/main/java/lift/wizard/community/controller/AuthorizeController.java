package lift.wizard.community.controller;

import lift.wizard.community.dto.AccessTokenDTO;
import lift.wizard.community.dto.GithubUser;
import lift.wizard.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("6a0f54825dc9de1dfecd");
        accessTokenDTO.setClient_secret("6fcf00383f05845c76fac5639cbaa878c2176254");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8886/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.gitUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }
}
