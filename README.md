# Assignment 5: Strategy Pattern Implementation

## Responsibilities Table
| Class | Responsibility |
| :--- | :--- |
| `ShippingPricingStrategy` | Interface defining calculation contracts for fulfillments. |
| `StandardShippingStrategy` | Evaluates base cost metrics. |
| `ExpressShippingStrategy` | Evaluates rush delivery pricing models. |
| `BulkShippingStrategy` | Evaluates volume discounted rates. |
| `ShippingPricingContext` | Holds current pricing algorithms dynamically. |
| `BoxSelectionStrategy` | Interface defining physical packaging selection. |
| `MinimalBoxStrategy` | Recommends smallest packaging boundaries. |
| `EcoFriendlyBoxStrategy` | Recommends eco sustainable packaging. |
| `ProtectedBoxStrategy` | Recommends reinforced padded packaging. |
| `PackingContext` | Holds current packaging algorithms dynamically. |
| `FulfillmentStrategySelector` | Chooses execution strategies automatically. |
| `FuelPriceProvider` | Abstraction for external fuel rates. |
| `SimulatedFuelPriceProvider` | Generates simulated fuel metrics. |

## Strategy vs. State vs. Template Method
This design uses the **Strategy Pattern** because our primary goal is providing interchangeable calculation algorithms at runtime selected dynamically based on business logic.

- **Why not State Pattern?** The State pattern changes context behaviors based on internal state transitions where states are aware of each other. In contrast, our strategies are independent, stateless algorithms oblivious to system states.
- **Why not Template Method Pattern?** Template Method uses subclass inheritance to alter specific algorithm steps while retaining structure. Strategy uses object composition, allowing us to completely switch algorithms dynamically at runtime without subclass tightly-coupled inheritance.

## Refactoring Git Commits
- **Before Refactoring (Monolithic if-else):** `<insert-your-first-commit-hash-here>`
- **After Refactoring (Clean Strategy Pattern):** `<insert-your-second-commit-hash-here>`