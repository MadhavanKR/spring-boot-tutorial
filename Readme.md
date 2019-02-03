1) spring boot eases package management - all compatibility issues are taken care
2) spring - anything in the class path, it will try to create a path.
   for ex: adding database dependency, spring will try to create a datasource bean.
3) bean - it is a managed object.
	
    in program - {
    MyClass obj = new MyClass();
    obj.init();
    -
    -
    -
    if(obj.connectionActive())
      obj.connect();
    }

    in bean :
    @Autowired
    MyClass obj;

4) spring-boot-starter-web dependency:
    this enables the web-applicaiton capability to your application
    in other words, adding this dep, makes your app a web-app.

    @Controller, @RestController, @Component, @Service, @Model, @RequestMapping
    @GetMapping

5) spring-boot-starter-jdbc dependency:
   this enables db interaction related beans.
   
for tomorrow:

@Value annotation - done
@Configuration - done
How to connect to and execute sqls on database
how to host on a windows server. (requires spring boot maven compiler plugin)
how to communicate data btw view(html) and controller and vice versa. 

employeeapp -insert sql /addEmployee - a form with basic emp details, submit will create a db row
			 delete sql /deleteEmployee?empId=xyz - deletes a employee from database
			 select sql /showEmployees - shows list of all employees.

			 
What to explore?
- how to create a dns for windows server
- how to run a process in background in windows