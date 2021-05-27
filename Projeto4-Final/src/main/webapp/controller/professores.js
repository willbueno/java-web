var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController", function ($scope, $http) {
	
	urlProfessores = 'http://localhost:8080/Projeto4-Final/rest/professores';
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessores).then(successCallback, errorCallback);
			
		function successCallback(professores) {
			//console.log("Professores: ", professores);
   			$scope.professores = professores.data;
		}
   			
   		function errorCallback(error) {
   			alert("Erro ao achar professores " + error);
 		};
	}
	
	$scope.selecionaProfessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.professor = null;
	}
	
	$scope.salvar = function() {
		//alert("codigo: " + $scope.professor.codigo);
		//console.log("codigo: " + $scope.professor.codigo);
		
		if ($scope.professor.codigo == undefined) {
			//console.log("POST - codigo vazio = novo registro");
			//alert("POST - codigo vazio = novo registro");
			$http.post(urlProfessores, $scope.professor).then(successCallback, errorCallback);
				
			function successCallback() {
				$scope.limparCampos();
				$scope.listarProfessores();
			}
			
			function errorCallback(error) {
				alert("Erro ao salvar professor " + error);
			};
		
		}
		else {
			//console.log("PUT - codigo nao vazio = altera registro");
			//alert("PUT - codigo nao vazio = altera registro");
			$http.put(urlProfessores, $scope.professor).then(successCallback, errorCallback);
			
			function successCallback() {
   				$scope.listarProfessores();
				$scope.limparCampos();
			}
			
			function errorCallback(error) {
   				alert("Erro ao salvar professor " + error);
 			};
		}
	}
	
	$scope.excluir = function() {
		//console.log("codigo: " + $scope.professor.codigo);
		
		if ($scope.professor.codigo == undefined) {
			console.log("Favor selecionar um registro para poder excluir");
			alert("Favor selecionar um registro para poder excluir");
		}
		else {
			$http.delete(urlProfessores+'/'+$scope.professor.codigo).then(successCallback, errorCallback);
			
			function successCallback() {
				$scope.limparCampos();
   				$scope.listarProfessores();
			}
			
			function errorCallback(error) {
   				alert("Erro ao deletar professor " + error);
 			};
		}
	}
	
	// executa
	$scope.listarProfessores();
	
});