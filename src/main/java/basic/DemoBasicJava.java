package basic;

public class DemoBasicJava {
    public static void main(String[] args) {
        // %s (string) la mot placeholder
//        String dynamicLocator = "//input[@type='radio' and @value='%s']";
//        String locator = String.format(dynamicLocator, "honda");
//        System.out.println(locator); // //input[@type='radio' and @value='honda']

        // %d (so nguyen - int)
//        String dynamicCheckbox = "(//input[@type='checkbox'])[%d]";
//        String chkbox1 = String.format(dynamicCheckbox, 1);
//        System.out.println(chkbox1);

//        String dynamicLocator = "//input[@type='radio' and @value='%s']";
//        String locator = dynamicLocator.replace("%s", "honda");
//        System.out.println(locator); // //input[@type='radio' and @value='honda']

        String dynamicLocator = "//input[@type='%s' and @value='%s']";
        String locator = String.format(dynamicLocator, "radio", "honda");
        System.out.println(locator); // //input[@type='radio' and @value='honda']
    }
}
