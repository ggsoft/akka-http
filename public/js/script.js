$(function() {

    $("#addgrp").click(function() {
        $.ajax( {
            type: "GET",
            url: "/addgrp",
            data: {name: $("#grp").val()},
            dataType: "text",
            success: function(data) {
                $("#listgrp").html(data);
            }
        })
    })

    $("#editgrp").click(function() {
        $.ajax( {
            type: "GET",
            url: "/editgrp",
            data: {id: $("#idgrp").html(),name: $("#grp").val()},
            dataType: "text",
            success: function(data) {
                $("#listgrp").html(data);
            }
        })
    })

    $("#delgrp").click(function() {
        $.ajax( {
            type: "GET",
            url: "/delgrp",
            data: {id: $("#idgrp").html()},
            dataType: "text",
            success: function(data) {
                $("#listgrp").html(data);
            }
        })
    })

    $("#addstd").click(function() {
        $.ajax( {
            type: "GET",
            url: "/addstd",
            data: {id: $("#idgrp").html(),name: $("#name").val(),ball: $("#score").val()},
            dataType: "text",
            success: function(data) {
                $("#list").html(data);
                tableEvents();
            }
        })
    })

    $("#editstd").click(function() {
        $.ajax( {
            type: "GET",
            url: "/editstd",
            data: {idGrp: $("#idgrp").html(),id: $("#idstd").html(),name: $("#name").val(),ball: $("#score").val()},
            dataType: "text",
            success: function(data) {
                $("#list").html(data);
                tableEvents();
            }
        })
    })

    $("#delstd").click(function() {
        $.ajax( {
            type: "GET",
            url: "/delstd",
            data: {idGrp: $("#idgrp").html(),id: $("#idstd").html()},
            dataType: "text",
            success: function(data) {
                $("#list").html(data);
                tableEvents();
            }
        })
    })

    tableEvents();

})

function tableEvents() {
    $("td > a").click(function() {
        $.ajax( {
            type: "GET",
            url: "/updstd",
            data: {id: $(this).parent().prev().html()},
            dataType: "json",
            success: function(data) {
              $("#idstd").html(data.id);
              $("#name").val(data.name);
              $("#score").val(data.score);
            }
        })
    })
}