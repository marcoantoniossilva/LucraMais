<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de produtos</h1>		

<form action="/login/crud/Produto/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${produto.id}">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome" value="${produto.nome}" autocomplete="off" required>
		<label for="login">Unidade de medida:</label>
		<input type="text" name="unidadeMedida" class="form-control" placeholder="Unidade de medida" value="${produto.unidadeMedida}" autocomplete="off" required>
		<label for="descricaoNutricional">Descri��o nutricional:</label>
		<textarea name="descricaoNutricional" class="form-control" rows="3" required>${produto.descricaoNutricional}</textarea>
		<label for="precoVenda">Pre�o de venda:</label>
		<div class="input-group">
	        <div class="input-group-prepend">
	        	<div class="input-group-text">R$</div>
	        </div>
			<input type="number" name="precoVenda" class="form-control" placeholder="0.00" value="${produto.precoVenda}" step="0.05" required >
     	</div>
		<label for="fornecedor">Fornecedor:</label>
		<select name="fornecedor" class="form-control" value="${produto.fornecedor.id}" required>
			<c:forEach items="${listaFornecedor}" var="fornecedor">
				<option value="${fornecedor.id}">${fornecedor.nome}</option>
			</c:forEach>
		</select>
		<label for="precoCompra">Pre�o de compra:</label>
		<div class="input-group">
	        <div class="input-group-prepend">
	        	<div class="input-group-text">R$</div>
	        </div>
			<input type="number" name="precoCompra" class="form-control" placeholder="0.00" value="${produto.precoCompra}" step="0.05" required>
     	</div>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Produto"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
