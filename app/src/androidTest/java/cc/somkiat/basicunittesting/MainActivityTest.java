package cc.somkiat.basicunittesting;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveButtonTestWithData() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("peakinw"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamer@msn.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void revertButtonTestWithData() {
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("peakinw"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamer@msn.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void reverButtontTestWithDataIsEmpty() {
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void SaveButtonTestWithDataIsEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name is empty");
    }

    @Test
    public void SaveButtonTestWithNameIsEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamer@msn.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name is empty");
    }

    @Test
    public void SaveButtonTestWithEmailIsEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("peak"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Email is empty");
    }

    @Test
    public void SaveButtonTestWithNameNotEnglish() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("123"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamer@msn.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("Peak123"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("#$!@$#!@#%$^&^%*&"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("peak#$!@$#!@#%$^&^%*&"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("6546peak#$6546!@$#!4554@#%12"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("ไทย"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("Name Only English.");
    }

    @Test
    public void SaveButtonTestWithEmailIsNotOnPattern() {
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("peak"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamermsncom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("not a email pattern");
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamermsn.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("not a email pattern");
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("gamer@msncom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("not a email pattern");
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("ga.mermsn@com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("not a email pattern");
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("dasdas84561!@#%$^._+="));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        CheckTextInDialog("not a email pattern");
    }

    public void CheckTextInDialog(String msg){
        onView(withText(msg)).check(matches(isDisplayed()));
        ok();
    }

    public void ok(){
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK")));
        appCompatButton2.perform(scrollTo(), click());
    }

}
