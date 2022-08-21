package bg.softuni.happytravel.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.param;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrationPageShown() throws Exception {

        mockMvc.perform(get("/register")).andExpect(status().isOk()).
                andExpect(view().name("register"));
    }

//    @Test
//    void testUserRegistration() throws Exception {
//        mockMvc.perform(post("/register").
//        param("email" , "annait@example.com").
//        param("fullName" , "Anna PetrovaIT").
//        param("username" , "annapetrovaIT").
//        param("password" , "topsecret").
//        param("confirmPassword" , "topsecret").
//                with(csrf())
//        ).andExpect(status().is3xxRedirection()).
//         andExpect(redirectedUrl("/login"))       ;
//    }




}
