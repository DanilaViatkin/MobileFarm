package by.refor.mobilefarm;

import by.refor.mobilefarm.controller.AnimalPassportController;
import by.refor.mobilefarm.model.bo.AnimalPassport;
import by.refor.mobilefarm.repo.AnimalPassportRepository;
import by.refor.mobilefarm.service.AnimalPassportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static sun.net.NetProperties.get;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {AnimalPassportController.class})
public class AnimalPassportControllerTest  {
    @Autowired
    private AnimalPassportController animalPassportController;
    private MockMvc mockMvc ;
    @MockBean
    private AnimalPassportService animalPassportService;
    @MockBean
    private AnimalPassportRepository animalPassportRepository;

    private static ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(animalPassportController).build();
    }

    @Test
    public void testGetExternal_id() throws Exception {
       List<AnimalPassport> animalPassports = new ArrayList<>();
       AnimalPassport passport=new AnimalPassport();
       passport.setExternalId("1115");
       passport.setOriginCountry("Belarus");
       animalPassports.add(passport);
        Mockito.when(animalPassportController.getAnimalPassportByExternalId("1115")).thenReturn(passport);
        mockMvc.perform(get("/external_id/" + passport.getExternalId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].originCountry", Matchers.equalTo("Belarus")));
    }

}
