package webserver;

import org.junit.jupiter.api.Test;
import util.extractor.ResourceExtractor;

class ResourceExtractorTest {

    @Test
    void name() {
        ResourceExtractor resourceExtractor = new ResourceExtractor("./webapp");
        resourceExtractor.getPaths().forEach(System.out::println);
    }
}