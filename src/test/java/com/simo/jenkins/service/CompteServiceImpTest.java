package com.simo.jenkins.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.simo.jenkins.dao.CompteDao;
import com.simo.jenkins.model.Compte;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class) // on peut l enlver et le test fonctionne

public class CompteServiceImpTest {

    @Mock
    private CompteDao daoMock;

    @InjectMocks
    private CompteServiceImp service;

    Compte p = new Compte();

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        p.setId(4);
        p.setDetenteur("mockProduct");
    }

    @Test
    public void recupererUnProduitTest() {

        // Configure mock
        when(daoMock.findById(4)).thenReturn(p);
        // Perform the test
        Compte CompteTest = service.recupererUnCompte(4);
        int actual = CompteTest.getId();

        // Junit asserts
        int expected = p.getId();
        assertEquals(expected, actual);
        //verfiy is the method is called
        verify(daoMock, Mockito.times(1)).findById(4);

    }

    @Test(expected = Exception.class)
    public void recupererUnProduit_should_return_null() throws Exception {

        // Configure mock
        doThrow(new Exception()).when(daoMock.findById(anyInt()));
        //perform the test must trow exception
        service.recupererUnCompte(4);

    }

    /*
    Mockito.verify(someMock, Mockito.never()).bla(); // same as Mockito.times(0)

    Mockito.verify(someMock, Mockito.atLeast(3)).bla(); // min 3 calls

    Mockito.verify(someMock, Mockito.atLeastOnce()).bla(); // same as Mockito.atLeast(1)

    Mockito.verify(someMock, Mockito.atMost(3)).bla(); // max 3 calls
*/
}



