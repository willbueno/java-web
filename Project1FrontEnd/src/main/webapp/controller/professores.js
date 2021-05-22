var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController", function ($scope) {
	$scope.professores = [
		{codigo: 1, nome:'Albertin', email:'poderoso@gmail.com', celular:'51 991534388'},
		{codigo: 2, nome:'Carlin', email:'carlin@gmail.com', celular:'51 991534377'},
		{codigo: 3, nome:'Robertin', email:'robertin@gmail.com', celular:'51 991534366'},
		{codigo: 4, nome:'Paulin', email:'paulin@gmail.com', celular:'51 991534355'},
	];
	
	$scope.selecionaProfessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.professor = null;
	}
	
	$scope.salvar = function() {
		$scope.professores.push($scope.professor);
		$scope.limparCampos();
	}
	
	$scope.excluir = function() {
		$scope.professores.splice($scope.professores.indexOf($scope.professor), 1);
		$scope.limparCampos();
	}
	
});