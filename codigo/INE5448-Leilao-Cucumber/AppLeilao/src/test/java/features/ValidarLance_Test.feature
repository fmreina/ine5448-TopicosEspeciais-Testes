Feature: Validar Lance
	Validar lance
	
	@CadastrarProdutosSucesso
	Scenario: Cadastrar Produto com sucesso
		Given O produto "cama de gato"
		And o cpf do comprados "021.993.711-74"
		And o lance "300.00"
		When O produto existir
		And o leiloador
		And o lance for maior que o valor minimo
		And o lance for maior que o anterior
		Then O sistema deve registrar o lance
