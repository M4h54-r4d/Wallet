package Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import Controller.AccountController;
import Entitiy.Account;
import Service.AccountService;

@WebMvcTest(AccountController.class)
public class AcountControllerTest {

    @Autowired
    private MockMvc mockMvc;  //  HTTP request

    @MockBean
    private AccountService accountService;  // service

    @Test
    public void testCreateAccount_Success() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setAccountNumber("123456789");
        account.setBalance(new BigDecimal("100000"));

        when(accountService.createAccount(any())).thenReturn(account);

        // POST
        mockMvc.perform(post("/api/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountNumber\":\"123456789\",\"balance\":100000}")
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.accountNumber").value("123456789"))
        .andExpect(jsonPath("$.balance").value(100000));
    }
}

