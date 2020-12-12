package singer;

public class SqSingerBiz {
    private final SqSingerDao dao = new SqSingerDao();

    public void delete(String id) {
        if (id == null) {
            //
        }

        dao.deleteSingerById(id);
    }

    public void create(SqSinger ss){


        dao.insert(ss);
    }
}
