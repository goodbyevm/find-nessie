Find Nessie - a Monty Hall problem
=============================

# 1 Background
Simulation to find out the probability of finding Nessie if lake is changed after given advice to change lake according to the classic Monty Hall Problem.

# 2 Layers
## 2.1 API
Layer that contain classes representing the API exposed via the REST client.
- NessieSearchResponse; Nessie search response which is sent back to the client.
- NessieSimulation; main AIP/endpoint.

## 2.2 Service
Layer acting as a glue between the API and model

- `NessieService`

## 2.3 Model
Application domain specific classes 

- `Fisherman`: Act as the advisor when choosing between lakes
- `LakeManager`: Helps out with the management of the lakes.
- `NessieGenerator`: As the name expose, generate Nessie into one of the lakes.

# 3 Tests
Main integration tests class can be found in path `find-nessie\src\test\java\pj\nessie\integration\TestNessieSimulation`. 
The class contain one integration's that solves the problem stated in the case `testChangeLakeProbability`.

To assure that the functionality acts as intended, a complete test suit has been developed and can be found in `find-nessie\src\test\java\pj\nessie` under corresponding package for api, model and service.

# 4 Miscellaneous
- Constructor injection is used where suited in order to make classes fully testable.