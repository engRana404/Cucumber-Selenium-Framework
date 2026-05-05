package com.qaplayground.utils;

import com.qaplayground.base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtils {
    public static void capture(String name) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Path dest = Path.of("target/reports/screenshots/" + name + ".png");
            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
