var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller("cursosController", function ($scope) {
	$scope.professores = [
		{codigo: 1, nome:'Albertin', email:'poderoso@gmail.com', celular:'51 991534388'},
		{codigo: 2, nome:'Carlin', email:'carlin@gmail.com', celular:'51 991534377'},
		{codigo: 3, nome:'Robertin', email:'robertin@gmail.com', celular:'51 991534366'},
		{codigo: 4, nome:'Paulin', email:'paulin@gmail.com', celular:'51 991534355'}];

	$scope.cursos = [
		{codigo: 1, nome:'Java para web', diashorarios:'Segundas e Quartas, 19 horas', professor:{codigo: 1, nome:'Albertin', email:'poderoso@gmail.com', celular:'51 991534388'}},
		{codigo: 2, nome:'Delphi', diashorarios:'Tercas e Quintas, 20 horas', professor:{codigo: 2, nome:'Carlin', email:'carlin@gmail.com', celular:'51 991534377'}},
		{codigo: 3, nome:'PHP', diashorarios:'Sabados, 09 horas', professor:{codigo: 3, nome:'Robertin', email:'robertin@gmail.com', celular:'51 991534366'}},
		{codigo: 4, nome:'Arduino', diashorarios:'Sextas, 07 horas', professor:{codigo: 4, nome:'Paulin', email:'paulin@gmail.com', celular:'51 991534355'}}];

	$scope.selecionaCurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.curso = null;
	}

	$scope.salvar = function() {
		$scope.cursos.push($scope.curso);
		$scope.limparCampos();
	}

	$scope.excluir = function() {
		$scope.cursos.splice($scope.cursos.indexOf($scope.curso), 1);
		$scope.limparCampos();
	}

});