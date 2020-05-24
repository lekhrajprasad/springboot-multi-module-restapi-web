package com.lpras.springboot.powermokito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.PowerMockUtils;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@PrepareForTest({Puppy.class})
@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"com.sun.org.apache.xerces.", "javax.xml.", "org.xml.", "org.w3c."})
public class PuppyTest {

    @Before
    public void init(){
        //MockitoAnnotations.initMocks(Human.class);
        MockitoAnnotations.initMocks(Puppy.class);
    }

    @Test
    public void testCreatePuppy() {

        //Given
        /*String name = "Woofer";
        PowerMockito.mockStatic(Puppy.class);
        Human human = Mockito.mock(Human.class);
        Puppy puppy = Mockito.mock(Puppy.class);*/
        Human human = Mockito.mock(Human.class);
        //When
        /*Puppy p = new Puppy(name, human);
        when(Puppy.createPuppy(name,human)).thenReturn(p);*/
        //Then

        //Mocking
        //Human human = Mockito.mock(Human.class);
        Puppy puppyRes = Puppy.createPuppy("Woofer", human);
        assert(puppyRes != null);
        assert(puppyRes.getName().equals("Woofer"));
        //Verifying
        Mockito.verify(human, times(1)).isSoHappy();

    }
}