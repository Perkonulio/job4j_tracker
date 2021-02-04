package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest{

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[] {"one", "1"});
        ValidateInput validateInput = new ValidateInput(out, input);
        int selected = validateInput.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1"});
        ValidateInput valid = new ValidateInput(out, in);
        int selected = valid.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMoreInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "2"});
        ValidateInput valid = new ValidateInput(out, in);
        int selected = valid.askInt("Enter menu: ");
        assertThat(selected, is(1));
        int selected2 = valid.askInt("Enter menu: ");
        assertThat(selected2, is(2));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1"});
        ValidateInput valid = new ValidateInput(out, in);
        int selected = valid.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }
}