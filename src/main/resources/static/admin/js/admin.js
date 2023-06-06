$(document).ready(function(){
    $('#selectAllBox').click(function(event){
        if(this.checked){
            $('.checkboxes').each(function(){
                this.checked = true
            })
        }else{
            $('.checkboxes').each(function(){
                this.checked = false
            })
        }
    })
})