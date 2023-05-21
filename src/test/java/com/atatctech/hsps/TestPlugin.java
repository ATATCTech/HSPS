package com.atatctech.hsps;

import com.atatctech.hsps.verification.Signed;
import org.jetbrains.annotations.Nullable;

@Signed("RC7xd6NuB8TkWybbZwlrVzczmfvNPAA0v1VjH/XomW8kwQWuojEUkqBc1GwZmMDl56bfoARut1xjcscaF97trirvYYvi8R/jJginyybElDEHnBktMJ42FY05j+4bxaLkSwUpekgXv13GybiEq9E7IOFlM9I+kS/RDsMYWHR7sSIyOZlLGwSG68qtfZnaynicqYu/QGCzXVGTf7uLQlmM3CSlTfYYf/CMCYAZKzBBFDk2rBUVw4uG1LzN6SI9ukbvzxwaZ/tlmWgz/zPrhPu4T2pmuNPohjPbUKmft5aesg6G36/ptD8JA0+m6G150aoZ5uT00HbMdDg0u+R2ibKpzg==")
public class TestPlugin implements Plugin {
    public static void run() {
        System.out.println("test");
    }

    @Override
    public void initialize(@Nullable Object... args) {
    }
}
