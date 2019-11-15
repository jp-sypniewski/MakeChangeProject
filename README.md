## Make Change Project

### Week 2 Homework - Skill Distillery

#### Overview

The 'register' calculates the amount of change returned to a customer based on the purchase price and amount tendered.  The 'attendant' is also notified how many of each piece of currency ($20, $10, etc.) is needed to make change for the customer.  Change is provided using the largest bill and coin denominations as possible.

#### Concepts

Simple methods, complex if chain, type coercion, scanners.

#### Technologies Used

Java

#### Lessons Learned

Executing simple math on doubles can result in small differences from integer math.  This program avoids that issue by adding a buffer such that the buffer doesn't impact the calculation of change yet it prevents calculation issues due to usage of double variables.