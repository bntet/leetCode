package com.xzq.study.nearestNode;

import java.util.ArrayList;
import java.util.List;

public class KDTree {
    private Node root;
    private int k = 2; // 2-dimensional tree for latitude and longitude

    public void insert(Point point) {
        root = insert(root, point, 0);
    }

    private Node insert(Node node, Point point, int depth) {
        if (node == null) {
            return new Node(point);
        }

        int axis = depth % k;
        if (axis == 0) {
            if (point.getLatitude() < node.point.getLatitude()) {
                node.left = insert(node.left, point, depth + 1);
            } else {
                node.right = insert(node.right, point, depth + 1);
            }
        } else {
            if (point.getLongitude() < node.point.getLongitude()) {
                node.left = insert(node.left, point, depth + 1);
            } else {
                node.right = insert(node.right, point, depth + 1);
            }
        }

        return node;
    }

    public Point findNearest(Point target) {
        return findNearest(root, target, 0).point;
    }

    private Node findNearest(Node node, Point target, int depth) {
        if (node == null) {
            return null;
        }

        Node best = node;
        double bestDistance = distanceSquared(node.point, target);

        int axis = depth % k;
        double diff = axis == 0 ?
                target.getLatitude() - node.point.getLatitude() :
                target.getLongitude() - node.point.getLongitude();

        Node next, other;
        if (diff < 0) {
            next = node.left;
            other = node.right;
        } else {
            next = node.right;
            other = node.left;
        }

        Node temp = findNearest(next, target, depth + 1);
        if (temp != null) {
            double tempDistance = distanceSquared(temp.point, target);
            if (tempDistance < bestDistance) {
                best = temp;
                bestDistance = tempDistance;
            }
        }

        if (diff * diff < bestDistance) {
            temp = findNearest(other, target, depth + 1);
            if (temp != null) {
                double tempDistance = distanceSquared(temp.point, target);
                if (tempDistance < bestDistance) {
                    best = temp;
                }
            }
        }

        return best;
    }

    private double distanceSquared(Point a, Point b) {
        double dLat = a.getLatitude() - b.getLatitude();
        double dLon = a.getLongitude() - b.getLongitude();
        return dLat * dLat + dLon * dLon;
    }

    public static void main(String[] args) {
        KDTree kdTree = new KDTree();

        // Insert some points into the KD tree
        kdTree.insert(new Point(39.9208, 116.3639));
        kdTree.insert(new Point(39.9112, 116.3656));
        kdTree.insert(new Point(39.9113, 116.3656));
        kdTree.insert(new Point(39.9140, 116.3660));
        kdTree.insert(new Point(39.9105, 116.4013));

        // Query the nearest point to the target location
        Point target = new Point(39.9150, 116.3700);
        Point nearest = kdTree.findNearest(target);

        System.out.printf("Nearest point: (%.4f, %.4f)\n", nearest.getLatitude(), nearest.getLongitude());
    }
}