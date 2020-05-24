package com.lpras.springboot.powermokito;

import com.lpras.springboot.powermokito.Human;
import com.lpras.springboot.powermokito.Puppy;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.times;

@PrepareForTest({Puppy.class})
@RunWith(PowerMockRunner.class)
@Ignore
public class PuppyTest {

    @Test
    public void testCreatePuppy() throws Exception {
        //Mocking
        Human human = Mockito.mock(Human.class);
        Puppy puppy = Puppy.createPuppy("Woofer", human);
        assert(puppy != null);
        assert(puppy.getName().equals("Woofer"));
        //Verifying
        Mockito.verify(human, times(1)).isSoHappy();

    }
}