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
        <p>If we annotate <code>@Autowired</code>postion where requires some interface,<br>
         but in container there are many implimentations of it could be thrown 
         <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/NoUniqueBeanDefinitionException.html">
         NoUniqueBeanDefinationException</a>. It can be resolved by:
         <code><a href =https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-scanning-qualifiers>
         @Qualifier("Desire_bean_id")
         </a></code><br>
         Qualifier can be applied on: constructor, setter, field</p>
    </li>
</ol>


