

    Unit Testing
      -> this is done by developers
      -> the process of testing the smallest testable components of a program and individually testable
      -> single source of responsibility means one method does one thing and then we can test each method
      -> a unit test typically only tests public functions


      How does this look? Here is an example with flat spec:

      > test spec is whatever the class is called with spec on the end

      class TwoNumbersSpec extends AnyFlatSpec{
        val nums = new TwoNumbers
        // whatever the method is called is in "--"
        "add" should "add numbers" in {
          assert(nums.add(1,2)==3)
        }
      }
     

    Test Driven Development
     --> when we write our unit tests first, run them, they fail, then we write the code to make it pass
     --> then we can refactor
     --> helps avoid bias when writing tests
     --> makes sure that the code meets expectations and is written to specification

  ** See class calculator for more demo-ing **
  

    Behavior Driven Development 
    --> focuses on behaviour from the user's perspective and is written in human-readable language to define requirements, this reduces ambiguity!
    --> This is known as Gherkin syntax
      > Given : sets the context
      > When: describes the actions taken 
      > Then: defines the expected outcome
      
   ex: I want to withdraw money from an ATM. I check my account and I have £100. I withdraw £20.
   > Given: I have 100£ in my account
   > When: I withdraw 20£
   > Then: 80£ is left in my account 
    
   Task : You're working on a banking app. The team is building a feature to transfer money between accounts.

    > Write 2 BDD scenarios using Gherkin syntax:
        - Focus on the expected behaviour of transferring money
        - use realistic examples with amounts and outcomes
        - you can use 'And'

    1)  Given: I have £10 in my account 
        When: I transfer £20 to my friend
        Then: The transfer doesn't go through and I get an error message 

    2)  Given: I misspelled the recipients email address
        When: I submit transfer of £20
        Then: The transfer doesn't go through and I get an error message
