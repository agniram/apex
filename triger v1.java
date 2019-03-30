trigger juncTrigger on junc__c (after insert) {
    List <Prop1__c> junction =  [select id, Available__c from Prop1__c where id in  (select prop1__c from junc__c where id in :Trigger.New)];
    List <Prop1__c> upList = new List <Prop1__c>();

    
    for (Prop1__c p : junction){
        if (p.Available__c==true){
            p.Available__c=false;
            upList.add(p);
        }
    }

    update upList;
}