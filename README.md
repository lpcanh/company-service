Demo Company Service
====================

This repository contain all source code using for demo backend (using spring-boot, spring-web, spring-data), and frontend using (angularjs 1.4.9, bootstrap 3.3.6, font-awesome 4.5.0)

# Features: 

### Company

  - List all company.
```
curl https://demo-company.herokuapp.com
```
  - Create new company.
```
curl curl -i -X POST -H "Content-Type: application/json" https://demo-company.herokuapp.com/company -d '{"name": "Le Phuoc Canh", "address": "4/3 Thang Nhi", "city": "Vung Tau", "country": "Viet Nam", "phone": "84938130683", "email": "lephuoccanh@gmail.com", "employees": [{"name": "Nguyen Ho Thu"}, {"name": "Tran Hoang Tan"}]}'
```
  - Update company.
```
curl -i -X POST -H "Content-Type: application/json" https://demo-company.herokuapp.com/company/1 -d '{"name": "Le Phuoc Canh", "address": "4/3 Thang Nhi", "city": "Vung Tau", "country": "Viet Name", "phone": "84938130683", "email": "lephuoccanh@gmail.com", "employees": [{"name": "Nguyen Ho Thu"}, {"name": "Tran Hoang Tan"}]}'
```
  - Delete Company.
```
curl -i -X DELETE https://demo-company.herokuapp.com/company/1
```

### Company's Benefical Owners

  - List all beneficial owners
```
curl -i -X GET https://demo-company.herokuapp.com/company/51/beneficial-owner
```
  - Create new Beneficial owner
```
curl -i -X POST -H "Content-Type: application/json" https://demo-company.herokuapp.com/company/51/beneficial-owner -d '{"name": "Doan Ngoc Binh"}'
```
  - Update beneficial owner
```
curl -i -X POST -H "Content-Type: application/json" https://demo-company.herokuapp.com/company/51/beneficial-owner/61 -d '{"name": "Doan Ngoc Binh 123"}'
```
  - Delete Beneficial owner
```
curl -i -X DELETE https://demo-company.herokuapp.com/company/51/beneficial-owner/61
```
