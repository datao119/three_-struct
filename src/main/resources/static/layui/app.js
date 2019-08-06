function findLevelTwo(parentId,form){
    //2. 判断是否为0
    var content = "<option value='0'>--请选择--</option>";
    if(parentId == 0){
        $("#levelTwo").html(content);
        $("#levelThree").html(content);
        form.render('select');
        return ;
    }
    //3. 不为0直接发送ajax请求.
    $.ajax({
        url: "/dev/app/category/" + parentId,
        data: null,
        type: "get",
        dataType: "json",
        success: function(result){
            if(result.code == 0){
                // 封装返回的json
                //4. 在成功的回调函数中,封装json,插入到二级分类中.
                for(var i = 0;i < result.data.length;i++){
                    content += "<option value='"+ result.data[i].id +"'>"+ result.data[i].categoryName +"</option>"
                }
                $("#levelTwo").html(content);
                $("#levelThree").html("<option value='0'>--请选择--</option>");
                form.render('select');
            }
        },
        error: function(){
            alert("刮大风,服务器起飞了,上天!!!");
        }
    });
}




function findLevelThree(parentId,form){
    //2. 判断是否为0
    var content = "<option value='0'>--请选择--</option>";
    if(parentId == 0){
        $("#levelThree").html(content);
        form.render('select');
        return ;
    }
    //3. 不为0直接发送ajax请求.
    $.ajax({
        url: "/dev/app/category/" + parentId,
        data: null,
        type: "get",
        dataType: "json",
        success: function(result){
            if(result.code == 0){
                // 封装返回的json
                //4. 在成功的回调函数中,封装json,插入到二级分类中.
                for(var i = 0;i < result.data.length;i++){
                    content += "<option value='"+ result.data[i].id +"'>"+ result.data[i].categoryName +"</option>"
                }
                $("#levelThree").html(content);
                form.render('select');
            }
        },
        error: function(){
            alert("刮大风,服务器起飞了,上天!!!");
        }
    });
}