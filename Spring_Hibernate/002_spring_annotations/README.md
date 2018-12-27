<h3>Spring configuration with annotations - IoC</h3>
<ol>
    <li><p><strong><i>Explicit/Default Component names</i></strong><br>
        - enable component scan in cfg file, specify the package.<br>
        - annotate needed class 
        <code>@Component("Bean_ID")</code><br>
        - if you do not specify Bean_ID,<br>
        id will be name of class starts with lowercase.</p>
    </li>
    <li><p><strong><i>DI with annotations. Autowiring.</i></strong>
        <ul>
            <li>For DI Spring scans package for classes according to type.
                        Sould be annotated: <code>@Component</code>.<br>
                        You can use <code>@Autowiring</code> for:
                        <ol>
                            <li>Constructor Injection</li>
                            <li>Setter Injection</li>
                            <li>Field Injection</li>
                        </ol>
            </li>
            <li>if there are multiple implementations of interface<br>
                         you sould use <code>@Qualifier</code></li>
            <li>As of Spring Framework 4.3, an @Autowired annotation <br>
                        on such a constructor is no longer necessary if the target bean<br>
                        only defines one constructor to begin with.<br>
                        However, if several constructors are available,<br>
                        at least one must be annotated to teach the container which one to use.<br>
                        <a href=https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation>reference</a>
            </li>
            <li>Also you can execute any method(that requred component) through @Autowired<br></li>
            <li>Autowired directy on the field<br>
            Spring could autowire field through reflection(even privat field, without setter) </li>
        </ul></p>
    </li>
    <li>
        <p><strong><i>Which type of injection should be used ?</i></strong><br></p>
        <article>There are not strict low, but best practice is to use single approch throughout project
        </article>
    </li>
    <li><strong><i><p>Qulifier annotations for DI</i></strong></p>
        <p></p>
        <p>If we annotate <code>@Autowired</code>postion where requires some interface,<br>
         but in container there are many implimentations of it could be thrown 
         <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/NoUniqueBeanDefinitionException.html">
         NoUniqueBeanDefinationException</a>. It can be resolved by:
         <code><a href =https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-scanning-qualifiers>
         @Qualifier("Desire_bean_id")
         </a></code><br>
         Qualifier can be applied on: constructor, setter, field</p>
    </li>
    <li><p>If the annotation's value doesn't indicate a bean name,
                an appropriate name will be built<br>
                based on the short name of the class (with the first letter lower-cased).</p>
        <p>For example: HappyFortuneService --> happyFortuneService
                <br>However, for the special case of when BOTH the first and second characters of the class name are upper case,<br>
                then the name is NOT converted. For the case of RESTFortuneService:
                RESTFortuneService --> RESTFortuneService<br>
                Thus "FooBah" becomes "fooBah" and "X" becomes "x", but "URL" stays as "URL".</p>
    </li>
    <li><strong><i>Syntax of autowiring constructor a little different:</strong></i>
    <p><code>@Autowired
                public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
    </code>
    </p>
    </li>
    <li>
        <strong><i>Properties injection using annotations</i></strong>
        <p> For example:
            <ol>
                <li>Add to config < context:property-placeholder location="classpath:sport.properties"/ >
                </li>
                <li>Create sport.property</li>
                <li>Inject the properties value into the Coach using annotation
                <code>@Value("${}")</code></li>
            </ol>
        </p>
    </li>
    <li>
        <p><strong><i>@PostConstruct and @PreDestroy</i></strong></p>
        <p>If you want to provide some operations after constraction/before destroy<br>
        you should annotate corresponding method.</p>
        <p>When using Java 9 and higher,
         javax.annotation has been removed from its default classpath. You should provide it for example:<br>
         http://central.maven.org/maven2/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar</p>
    </li>
    <li>
        <p><strong><i>@Scope("singleton"/"prototype") </i></strong></p>
        <p>If the scope is prototype pre destroy method will not be called.</p>
        <i><p>Special Note about @PostConstruct and @PreDestroy Method Signatures</p>
        <br>
        <h5>Access modifier</h5>
        <br>
        <p>The method can have any access modifier (public, protected, private)</p>
        <br>
        <h5>Return type</h5>
        <p>The method can have any return type.</p>
        <p>However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value.</p>
        <p>As a result, "void" is commonly used.</p>
        <br>
        <h5>Method name</h5>
        <p>The method can have any method name.</p>
        <br>
        <h5>Arguments</h5>
        <p>The method can not accept any arguments. The method should be no-arg.<br>
         The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding. </p></i>
        <br>
        <p>To get Spring container to release resources, held by prototype-scoped try using a custom 
        <a href=https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-extension-bpp>bean post-processor</a></p>
        <p>You sould provide javax.annotation-api Jar for Java 9, 10, 11</p>
    </li>
</ol>