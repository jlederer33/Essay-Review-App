package com.example.EssayReviewApp.persistence;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

import java.util.Map;

public class FirestoreFacade implements IPersistenceFacade {
    private static final String USER_ESSAYS_COLLECTION = "userEssays";
    private static final String ALL_ESSAYS_COLLECTION = "allEssays";

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void saveUserEssay(@NonNull Essay essay){
        CollectionReference cref = this.db.collection(USER_ESSAYS_COLLECTION);

        DocumentReference dref = cref.document(essay.id.toString());

        dref.set(essay.toMap());
    }

    public void saveAllEssay(@NonNull Essay essay){
        CollectionReference cref = this.db.collection(ALL_ESSAYS_COLLECTION);

        DocumentReference dref = cref.document(essay.id.toString());
        dref.set(essay.toMap());

        CollectionReference cref2 = this.db.collection(USER_ESSAYS_COLLECTION);
        DocumentReference dref2 = cref2.document(essay.id.toString());

        dref2.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("Essay Review App", "Essay deleted from User Collection");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Essay Review App", "Essay was not deleted from user collection");
            }
        });
    }

    public void removeUserEssay(@NonNull Essay essay) {
        CollectionReference cref = this.db.collection(USER_ESSAYS_COLLECTION);
        DocumentReference dref = cref.document(essay.id.toString());
        dref.delete();
    }


    @Override
    public void retrieveEssays(@NonNull Listener listener) {
        Dashboards dashboard = new Dashboards();

        Task<QuerySnapshot> usertask = this.db.collection(USER_ESSAYS_COLLECTION).get();
        Task<QuerySnapshot> alltask = this.db.collection(ALL_ESSAYS_COLLECTION).get();
        usertask.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot qsnap) {
                for (DocumentSnapshot dsnap : qsnap) {
                    Map<String, Object> mapData = dsnap.getData();
                    Essay essay = Essay.fromMap(mapData);
                        dashboard.userEssayList.add(essay);

                }
            }
        });
        alltask.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot qsnap) {
                for(DocumentSnapshot dsnap: qsnap){
                    Map<String, Object> mapData = dsnap.getData();
                    Essay essay = Essay.fromMap(mapData);
                    dashboard.allEssaysList.add(essay);
                }
            }
        });
    }


}
