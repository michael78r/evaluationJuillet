
var text;
<c:if test="${afficherModal}">
    text = document.getElementById('text');
    <c:set value="${erreur}" var="michael"></c:set>
</c:if>
        (function () {
            const toastPlacementExample = document.querySelector('.toast-placement-ex'),
                    toastPlacementBtn = document.querySelector('#showToastPlacement');
            let selectedType, selectedPlacement, toastPlacement;
            // Dispose toast when open another
            function toastDispose(toast) {
                if (toast && toast._element !== null) {
                    if (toastPlacementExample) {
                        toastPlacementExample.classList.remove(selectedType);
                        DOMTokenList.prototype.remove.apply(toastPlacementExample.classList, selectedPlacement);
                    }
                    toast.dispose();
                }
            }


// Placement Button click
            if (toastPlacementBtn) {


                document.addEventListener("DOMContentLoaded", function () {
                    var evenementClic = new Event("click");
                    toastPlacementBtn.dispatchEvent(evenementClic);
                    if (toastPlacement) {
                        toastDispose(toastPlacement);
                    }
                    selectedType = document.querySelector('#selectTypeOpt').value;
                    selectedPlacement = document.querySelector('#selectPlacement').value.split(' ');
                    text.innerText = "${michael}";
                    toastPlacementExample.classList.add(selectedType);
                    DOMTokenList.prototype.add.apply(toastPlacementExample.classList, selectedPlacement);
                    toastPlacement = new bootstrap.Toast(toastPlacementExample);
                    toastPlacement.show();
                });
            }
        })();

