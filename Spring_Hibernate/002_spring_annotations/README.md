<h3>Spring configuration with annotations - IoC</h3>
<ol>
    <li><h4>Explicit/Default Component names</h4>
        - enable component scan in cfg file, specify the package.<br>
        - annotate needed class 
        <code>@Component("Bean_ID")</code><br>
        - if you do not specify Bean_ID,<br>
        id will be name of class starts with lowercase.
    </li>
    <li><h4>DI with annotations. Autowiring.</h4>
        -For DI Spring scans package for classes according to type.
        Sould be annotated: <code>@Component</code>.<br>
        You can use <code>@Autowiring</code> for:
        <ol>
            <li>Constructor Injection</li>
            <li>Setter Injection</li>
            <li>Field Injection</li>
        </ol>
        - if there are multiple implementations of interface<br>
         you sould use <code>@Qualifier</code>
        - As of Spring Framework 4.3, an @Autowired annotation <br>
        on such a constructor is no longer necessary if the target bean<br>
        only defines one constructor to begin with.<br>
        However, if several constructors are available,<br>
        at least one must be annotated to teach the container which one to use.<br>
        <a href=https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation>reference</a>
    </li>
</ol>


