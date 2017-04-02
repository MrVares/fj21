<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="value" %>
<input id="${id}" name="${id}" value="${value}"/>
<script>
	$(document).ready(function() {
		$('#${id}').datepicker({
			changeYear: true,
			dateFormat: 'dd/mm/yy',
		    dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado'],
		    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'],
		    monthNames: ['Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		    nextText: 'Pr�ximo',
		    prevText: 'Anterior'		    
		});
	});	
</script>