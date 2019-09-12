package Tasks;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;


public class number_1 {
    @BeforeMethod

    public void settings(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = Boolean.parseBoolean("true");

    }


    @Test
    public void test() {

        open("https://yandex.ru/");
        $(linkText("Маркет")).click();
        $(linkText("Электроника")).click();
        $(linkText("Смартфоны")).click();
        $(linkText("Все фильтры")).click();

        $(id("glf-pricefrom-var")).setValue("20000");
        $$(".checkbox__label").findBy(exactText("Apple")).click();
        $$(".checkbox__label").findBy(exactText("Samsung")).click();
        $(".button_action_show-filtered").click();

        $$(".n-snippet-cell2").shouldHave(size(48));

        String phone_1 = $$(".n-snippet-cell2").get(0).getText();
        String model_for_search1 = $$(".n-snippet-cell2__title").get(0).getText();

        $("#header-search").setValue(model_for_search1).pressEnter();
        String model_for_search2 = $$(".n-snippet-cell2__title").get(0).getText();

        System.out.println((model_for_search2.equals(model_for_search1)));



    }
}


