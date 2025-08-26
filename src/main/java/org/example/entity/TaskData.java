package org.example.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }


    public Set<Task> getTasks(String who) {
        switch (who.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(Arrays.asList(annsTasks, bobsTasks, carolsTasks, unassignedTasks));
            default:
                return Collections.emptySet();
        }
    }

    public Set<Task> getUnion(Set<Task> s1, Set<Task> s2) {
        Set<Task> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }



    public Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> s : sets) {
            union.addAll(s);
        }
        return union;
    }


    public Set<Task> getIntersection(Set<Task> s1, Set<Task> s2) {
        Set<Task> intersect = new HashSet<>(s1);
        intersect.retainAll(s2);
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> s1, Set<Task> s2) {
        Set<Task> diff = new HashSet<>(s1);
        diff.removeAll(s2);
        return diff;
    }


}
