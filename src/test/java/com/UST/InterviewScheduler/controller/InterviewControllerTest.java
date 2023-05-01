package com.UST.InterviewScheduler.controller;

import com.UST.InterviewScheduler.entity.Interview;
import com.UST.InterviewScheduler.services.InterviewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InterviewController.class)
class InterviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InterviewService mockInterviewService;

    @Test
    void testAddInterview() throws Exception {
        // Setup
        // Configure InterviewService.createInterview(...).
        final Interview interview = new Interview(0, "name", "emailid", "phno", "skills", 0,
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "time", "link", "poc");
        when(mockInterviewService.createInterview(new Interview(0, "name", "emailid", "phno", "skills", 0,
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "time", "link", "poc")))
                .thenReturn(interview);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/h/schedule")
                        .content(asJsonString(interview)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Interview interview) {

            try{
                return new ObjectMapper().writeValueAsString(interview);
            }
            catch(JsonProcessingException e){
                e.printStackTrace();
            }
            return null;
        }


    @Test
    void testGetAllInterview() throws Exception {
        // Setup
        // Configure InterviewService.getInterview(...).
        final List<Interview> interviews = List.of(new Interview(0, "name", "emailid", "phno", "skills", 0,
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "time", "link", "poc"));
        when(mockInterviewService.getInterview()).thenReturn(interviews);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/h/interviewer")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//       assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAllInterview_InterviewServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockInterviewService.getInterview()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/h/interviewer")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetInterviewById() throws Exception {
        // Setup
        // Configure InterviewService.getInterviewById(...).
        final Interview interview = new Interview(0, "name", "emailid", "phno", "skills", 0,
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "time", "link", "poc");
        when(mockInterviewService.getInterviewById(0)).thenReturn(interview);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/h/interviewer/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
