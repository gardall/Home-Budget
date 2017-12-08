$(document).ready(function () {
    $('#allTransactionsTable').DataTable();
    $('#currentUserTransactionsTable').DataTable();
    $('#submitTransactionFormButton').click(function () {
        checked = $("input[type=checkbox]:checked").length;

        if (!checked) {
            alert("Check at least one target user!");
            return false;
        }
    });
});