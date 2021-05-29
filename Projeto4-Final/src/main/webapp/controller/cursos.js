var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller("cursosController", function ($scope, $http) {
	
	urlProfessores = 'http://localhost:8080/Projeto4-Final/rest/professores';
	urlCursos = 'http://localhost:8080/Projeto4-Final/rest/cursos';
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessores).then(successCallback, errorCallback);
			
		function successCallback(professores) {
			console.log("Professores: ", professores);
   			$scope.professores = professores.data;
		}
   			
   		function errorCallback(error) {
   			alert("Erro ao achar professores " + error);
 		};
	}
	
	$scope.listarCursos = function() {
		$http.get(urlCursos).then(successCallback, errorCallback);
			
		function successCallback(cursos) {
			console.log("Cursos: ", cursos);
   			$scope.cursos = cursos.data;
		}
   			
   		function errorCallback(error) {
   			alert("Erro ao achar cursos " + error);
 		};
	}
	
	$scope.selecionaCurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}
	
	$scope.limparCampos = function() {
		$scope.curso = null;
	}
	
	$scope.salvar = function() {
		//alert("codigo: " + $scope.curso.codigo);
		//console.log("codigo: " + $scope.curso.codigo);
		
		if ($scope.curso.codigo == undefined) {
			//alert("POST - codigo vazio = novo registro");
			//console.log("POST - codigo vazio = novo registro");
			$http.post(urlCursos, $scope.curso).then(successCallback, errorCallback);
				
			function successCallback() {
				$scope.limparCampos();
				$scope.listarCursos();
			}
			
			function errorCallback(error) {
				alert("Erro ao salvar professor " + error);
			};
		
		}
		else {
			//console.log("PUT - codigo nao vazio = altera registro");
			//alert("PUT - codigo nao vazio = altera registro");
			$http.put(urlCursos, $scope.curso).then(successCallback, errorCallback);
			
			function successCallback() {
   				$scope.listarCursos();
				$scope.limparCampos();
			}
			
			function errorCallback(error) {
   				alert("Erro ao salvar professor " + error);
 			};
		}
	}
	
	$scope.excluir = function() {
		console.log("codigo: " + $scope.curso.codigo);
		
		if ($scope.curso.codigo == undefined) {
			console.log("Favor selecionar um registro para poder excluir");
			alert("Favor selecionar um registro para poder excluir");
		}
		else {
			$http.delete(urlCursos+'/'+$scope.curso.codigo).then(successCallback, errorCallback);
			
			function successCallback() {
   				$scope.listarCursos();
				$scope.limparCampos();
			}
			
			function errorCallback(error) {
   				alert("Erro ao deletar professor " + error);
 			};
		}
	}
	
	// executa
	$scope.listarCursos();
	$scope.listarProfessores();
	
});