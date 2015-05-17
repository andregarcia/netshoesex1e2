

GET:

Obtém um registro de cep. Caso o cep não seja encontrado, os digitos são substituídos por zero, da direita para a esquerda, até que se encontre um cep ou até todos os dígitos serem substituidos por 0.

Os ceps atualmente cadastrados são:
01311000
05426200
05402000
04013040
01418000


endpoint:
http://localhost:8080/netshoesex1e2/zipcode/{zipcode}

{zipcode} deve ser um cep válido (i.e. constituído por 8 digitos, sem traço) e existente na base 

exemplo de GET:
curl -X GET http://localhost:8080/netshoesex1e2/zipcode/01311000  -v

status codes:
200 (ok): o cep foi encontrado
404 (not found): o cep não foi encontrado
400 (bad request): o formato do cep é inválido


exemplo de resposta quando o cep é encontrado:
{"zipcode":"01311000","street":"Avenida Paulista","district":"Bela Vista","city":"São Paulo","state":"SP"}

