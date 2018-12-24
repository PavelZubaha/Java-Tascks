<h2>Spring and Hibernate step by step.</h2>


<ol>
    <li>
    <h4>
    Follow the commits, step by step*.
    </h4>
    Create simple java project.<br>
    *Add spring jar's to classpath.
    For example you can download it from: 
    http://repo.spring.io/release/org/springframework/spring/
    or use maven.
    </li>
    <li>    <h4> Learn principles:    </h4>
    <ol type ="1">
    <li>Inversion of Control - approach in programming when 
     creating(Object Factory) and managing objects by Spring Container.</li>
    <li>Dependency injection - inject object's dependency
    specified in:
     <ol>
     <li>Configuration file;
     </li>
      <li>Annotation or source code;
      </li>
      <li>Source code.
      </li>
     </ol>
     </li>
    </ol>
    </li>
    <li>
    <h4><strong>Dependency injection</strong> can be provided by:</h4>
    <ol>
    <li><strong>Constructor injection
    <a href ="">DI:XML Configuration<a></strong>
    <ol>
        <li>Create constructor in the class.</li>
        <li>Configure DI in the spring cfg file:
         </li>
        </ol>
    </li>
    <li>
    <strong>Setter injection.</strong> - injection dependency calling setter.
    <ol>
    <li>Create setter method in the class.</li>
    <li>Configure DI in the spring cfg file.</li>
    <ol>
                <li>Otherbean DI: property ref = "bean_id"</li>
                <li>someValue DI: property value = "someValue"</li>
                <li>Using .propery file. 
                <br>Create property file.
                <br>Load file:
<code>&lt;context:property-placeholder location="classpath:sport.properties"/&gt;</code><br>
<code>&lt;property name="city" value="${foo.city}" /&gt;</code>
                </li>
    </ol>
    </ol>
    </li>
    <li><strong>Auto-wiring annotation</strong>:</li>
    </ol>
    </li>
</ol>





