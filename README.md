# PrizyPricer



An offline survey about different products and their prices

Envirinment : 
Maven multi module porject, spring (security, ORM, MVC, Transactions, AOP), hibernate, Mysql-database, wildfly-11.0.0 server, jsps

Steps to run the project : 

1. run the "prizy_pricer_Dump20180510.sql", to create the schema and tables on mysql work banch
  these are the 3 tables like..,
  product (product_id(pk), barcaode, store_id, description, notes, all_prices)
  product_store(product_id(pk), store_id(pk), price, quality)
  store(store_id(pk), name)

2. Deploy the individual madules onto wildfly server 

3. For Admin module, username : admin,  
                     password : admin123
                     
   For Surveyor module, username : dev,  
                        password : dev123
