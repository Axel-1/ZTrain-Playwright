package io.github.axel1;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ExcludeTags({"login", "search"})
public class TestRunner {

}
