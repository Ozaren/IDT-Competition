# Questions on valuable package

The problem description stated "IDT has also aggregated all of the data for all of the packages in one place since all of the packages report to the same RESTful web service."

1.1 What data for packages are being tracked by IDT? Below are few examples that I can think of
package identifier - an ID uniquely identifies a package from all packages
package dollar value - the monetary value of package
sender name - first name, mi, last name
sender address - street number, street address, city, state, country, zip
receiver name - first name, mi, last name
receiver address - street number, street address, city, state, country, zip
delivery method - the delivery service (regular vs express) the package is paid for
estimated delivery date - the date the package is expected to deliver to the receiver
delivery fee - money paid for the delivery service
actual delivery date - the date the package is actually delivered to receiver

1.2 Is new solution supposed to provide create/update functions for package data? As you see, all above data are static meaning they don’t change. The only dynamic data is position data of package. which I think is the key to the project.
1.3 where is this “one place” that IDT aggregates all package data? what is “RESTful web service” that package report to? Are these two different components for same solution, or they are same thing but being called differently?

2. Position data tracking
2.1 what format of position data is required for the solution? is it GPS coordinates, or is it street address? If both are accepted, then we need to have conversion function to convert one to the other. 
2.2 also the history of position data should be kept, but for how long? 3 months, 1 year?
2.3 how frequent the position data is scheduled to be tracked?
frequency per increment of time (hours/minutes), or
frequency per location change (in route vs arrival to branch)
on demand (whenever needed)
2.4 I assumed the timestamp that comes along with position data should be kept.
2.5 what if the GPS unit attached to the package stops working? then there will be no gps data, do we continue delivery the package or do we get gps unit replaced first?
2.6 Is new solution supposed to provide create/update functions for position data for package?

3. Reuse of gps unit
3.1 is gps unit supposed to be reused? that is when one package is delivered, should gps unit be taken out and reuse for next package. or should we assume a new gps unit is always given to a package? we have to design our code differently per the response.

4. Questions on the IDT solution
4.1 the IDT claimed "We will be giving you our solution so that you can use it to develop the other side." what does this IDT solution do? what problem does it solve in the context?  What problem is our solution (aka other side) supposed to solve?
4.2 how should our solution interface with existing IDT solution? Is this through web service? We need to know the specs of existing solution. When and how are we going to get the existing solution so we can start the work?

5. Questions on requirements for new solution
5.1 does solution need to detect service delay? that is if the delivery is not completed after the estimated delivery date 
5.2 does solution need to detect GPS unit malfunction
5.3 does solution need to handle no receiver home, redelivery, return to sender?
5.4 does solution need to handle insurance and claim for lost/damaged package?
again we need to find out what our solution is supposed to do with the existing IDT solution. it’s so vague.

6. Questions on Judging Parameters & Criteria
6.1 The 5th bullet says “Code correctness and completeness”. How correctness and completeness be evaluated? Is it against our own requirements which referred in 2nd bullet? or is it against the IDT requirements that are not known to us?  It is unfair if we will being evaluated against an invisible requirements.
6.2 In Problem Description, it was said “we are intentionally giving you a vague problem statement with the expectation that we will work together to arrive at an understanding of our vision. This process will include a week for your team to submit questions to IDT that will help your team define the task,”  How soon (in hours) will we expect answers from you?  Also in real world, the requirement gathering is a critical process that is backed with full collaboration of customers. In this contest, there is no face to face discussion, or real time interactions. We think a lot of details might be lost in this asynchronous way. How can you ensure we get accurate and sufficient information from you in such a short of period of time to write quality requirements? Do you have one person to answer all questions from all 16 teams, or there are multiple people who will answer questions? If there are multiple people, how can you ensure answers are consistent among your team? If there is only one person, how can you ensure questions will be answered in a timely manner?
