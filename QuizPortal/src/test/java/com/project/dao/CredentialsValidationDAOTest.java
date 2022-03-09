package com.project.dao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CredentialsValidationDAOTest {
    CredentialsValidationDAO credentialsValidationDAO=new CredentialsValidationDAO();
    @Test
    void checkCredentials() {
        Map<String, String> map=new HashMap<>();
        map.put("Shivam","password");
        credentialsValidationDAO.checkCredentials("Shivam","password");
        assertEquals(false,credentialsValidationDAO.checkCredentials("shivam","password"));
    }

    @Test
    void registerNewUser() {
        assertTrue(credentialsValidationDAO.registerNewUser("username","password"));

    }
    @Test
    void checkForUserName() {

        assertEquals(false,credentialsValidationDAO.checkForUserName("username"));
    }
}