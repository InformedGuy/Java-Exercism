class Badge {
    public String print(Integer id, String name, String department) {
        if (department == null) {
            department = "owner";
        }

        if (id == null) {
            return name + " - " + department.toUpperCase();
        } else {
            return "[" + id + "] - " + name + " - " + department.toUpperCase();
        }
    }
}
