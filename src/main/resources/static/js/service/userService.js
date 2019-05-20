app.service("testService",function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get("user/");
    }


    this.search=function(page,size){
        return $http.get("user/search/lisi/"+page+"/"+size);
    }

})