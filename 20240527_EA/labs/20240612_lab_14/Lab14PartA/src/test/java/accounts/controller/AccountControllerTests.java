package accounts.controller;

import accounts.service.AccountResponse;
import accounts.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        Mockito.when(accountService.getAccount("123456"))
                .thenReturn(new AccountResponse("123456", 1000D, "Ariel"));

        Mockito.doNothing().when(
                accountService).createAccount("123457", 1000D, "Ariel Adhikari");

        Mockito.when(accountService.getAccount("123457")).thenReturn(null);
    }

    @Test
    void getAccount_shouldReturnAccount() throws Exception {
        // Act
        mockMvc.perform(get("/account/123456")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(1000D))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Ariel"));
    }

    @Test
    void createAccount_shouldReturnAccount() throws Exception {
        // Act and assert
        mockMvc.perform(post("/createaccount/123457/1000/Ariel%20Adhikari")).andExpect(status().isOk());
    }

    @Test
    void getAccount_shouldNotReturnAccount() throws Exception {
        // Act
        mockMvc.perform(get("/account/123457")).andExpect(status().isNotFound());
    }
}
