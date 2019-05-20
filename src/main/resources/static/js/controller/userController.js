app.controller("testController",function($scope,testService){
    //显示所有的数据

    $scope.list = [];
    $scope.find=function(){
        testService.findAll().then(
            function(response){
                console.info(response)
                $scope.list=response.data;
            }
        );
    }

    //分页查询
    $scope.search=function(page,size){
        testService.search(page,size).then(function(response){
                $scope.list=response.data.content;
                console.info(response)
                //$scope.paginationConf.totalItems=response.total;//更新总记录数
        })
    }


    //配置分页控件
    $scope.paginationConf={
        currentPage: 1,
        //总记录数
        totalItems: 10,
        //每页显示的记录数
        itemsPerPage: 2,
        //选择每页显示的记录数数据
        perPageOptions: [5,7,9,15,25],
        onChange: function () {
            $scope.reloadList();
        }
    };

    //编写一个获取分页方法，不需要传递当前页码、每页记录数
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

})
