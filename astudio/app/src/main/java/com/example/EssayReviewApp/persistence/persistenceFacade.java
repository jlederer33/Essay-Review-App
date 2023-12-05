package com.example.EssayReviewApp.persistence;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

/**
public class persistenceFacade {
    public class FirestoreFacade implements IPersistenceFacade{

        private static final String SALES_COLLECTION = "sales";
        private final FirebaseFirestore db = FirebaseFirestore.getInstance();

        /**
         * Saves the sale passed in as input to the underlying persistence solution.
         * @param sale the sale to be saved
         */
       /** @Override
        public void saveSale(@NonNull Sale sale) {
            CollectionReference cref = this.db.collection(SALES_COLLECTION);
            cref.add(sale.toMap());
        }

        /**
         * Issues a ledger retrieval operation.
         * @param listener the observer to be notified of query result.
         */
       /** @Override
        public void retrieveLedger(@NonNull Listener listener) {

            Ledger ledger = new Ledger();

            Task<QuerySnapshot> task = this.db.collection(SALES_COLLECTION)
                    .get();

            task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot qsnap) {

                    for (DocumentSnapshot dsnap : qsnap){
                        Map<String, Object> mapData = dsnap.getData();
                        Sale sale = Sale.fromMap(mapData);
                        ledger.addSale(sale);
                    }
                    listener.onLedgerReceived(ledger);
                }
            });
        }
    }

}
*/