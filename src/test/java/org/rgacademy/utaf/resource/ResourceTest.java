package org.rgacademy.utaf.resource;

import org.rgacademy.utaf.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("file:/Users/rangegowdaym/IdeaProjects/TestAutomationFramework/src/test/resources/data/testdata.csv")
    private Resource resource1;


    @Value("https://www.google.com")
    private Resource resource2;

    @Value("${user.dir}${screenshot.path}/goo.html")
    private Path path;


    @Value("${user.dir}${screenshot.path}")
    private Path dynamicPath;
    @Autowired
    private ResourceLoader resourceLoader;


    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);

        Files.readAllLines(resource1.getFile().toPath()).forEach(System.out::println);

        System.out.println(new String(resource2.getInputStream().readAllBytes()));

        //Download file
        FileCopyUtils.copy(resource2.getInputStream(), Files.newOutputStream(path));
    }

    @Test(dataProvider = "getData")
    public void testResource(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(dynamicPath.resolve(saveAs))
        );
    }

    @Test
    public void propertyTest() throws IOException {
        System.out.println(
                PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("data/project.properties"))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath()).stream().map(s -> s.split(",")).toArray(Object[][]::new);
    }
}
